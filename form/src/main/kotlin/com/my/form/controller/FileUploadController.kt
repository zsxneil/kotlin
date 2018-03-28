package com.my.form.controller

import com.my.form.exception.StorageFileNotFoundException
import com.my.form.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.io.IOException
import java.util.stream.Collectors

@Controller
class FileUploadController @Autowired
constructor(private val storageService: StorageService) {

    @GetMapping("/upload")
    @Throws(IOException::class)
    fun listUploadFiles(model:Model) : String {
        model.addAttribute("files", storageService
                .loadAll()
                .map { path -> MvcUriComponentsBuilder
                        .fromMethodName(FileUploadController ::class.java,
                                "serveFile",
                                path.fileName.toString()).build().toString()
                }.collect(Collectors.toList())
        )
        return "uploadForm"
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    fun serveFile(@PathVariable filename:String) : ResponseEntity<Resource>{
        val file = storageService.loadAsResource(filename)
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.filename + "\"")
                .body(file)
    }

    @PostMapping("/upload")
    fun handleFileUpload(@RequestParam("file") file:MultipartFile,
                         redirectAttributes: RedirectAttributes) : String{
        storageService.store(file)
        redirectAttributes.addFlashAttribute("message",
                "you successfully uploaded " + file.originalFilename + " !")
        return "redirect:/upload"
    }

    @ExceptionHandler(StorageFileNotFoundException::class)
    fun handleStroageFileNotFound(exc:StorageFileNotFoundException):ResponseEntity<*> {
        return ResponseEntity.notFound().build<Any>()
    }

}