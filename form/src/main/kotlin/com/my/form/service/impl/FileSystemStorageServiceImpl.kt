package com.my.form.service.impl

import com.my.form.config.StorageProperties
import com.my.form.exception.StorageException
import com.my.form.exception.StorageFileNotFoundException
import com.my.form.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.stream.Stream

@Service
class FileSystemStorageServiceImpl @Autowired
    constructor(properties: StorageProperties) : StorageService {

    private val rootLocation : Path

    init {
        this.rootLocation = Paths.get(properties.location)
    }

    override fun init() {
        try {
            Files.createDirectories(rootLocation)
        } catch (e: Exception) {
            throw StorageException("Could not initialize storage", e)
        }

    }

    override fun store(file: MultipartFile) {
        val filename = StringUtils.cleanPath(file.originalFilename)
        try {
            if (file.isEmpty){
                throw StorageException("Failed to store empty file " + filename)
            }
            if (filename.contains("..")) {
                // This is a security check
                throw StorageException(
                        "Cannot store file with relative path outside current directory " + filename)
            }
            Files.copy(file.inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING)

        } catch (e: Exception) {
            throw StorageException("Failed to store file " + filename, e)
        }
    }

    override fun loadAll(): Stream<Path> {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter{path -> path != this.rootLocation}
                    .map { path -> this.rootLocation.relativize(path)  }
        } catch (e: Exception) {
            throw StorageException("Failed to read stored files ", e)
        }
    }

    override fun load(filename: String): Path {
        return this.rootLocation.resolve(filename)
    }

    override fun loadAsResource(filename: String): Resource {
        try {
            val file = load(filename)
            val resource = UrlResource(file.toUri())
            return if (resource.exists() || resource.isReadable) {
                resource
            } else {
                throw StorageFileNotFoundException("Could not read file: " + filename)
            }
        } catch (e: Exception){
            throw StorageFileNotFoundException("Could not read file: " + filename, e)
        }
    }

    override fun deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile())
    }
}