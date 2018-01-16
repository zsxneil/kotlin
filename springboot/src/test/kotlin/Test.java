public class Test {

    public static void main(String[] args) {
        String systemUserNumSql = "SELECT  t.year 年份,\n" +
                "        t.half 半年,\n" +
                "        t.quarter 季度,\n" +
                "        t.month 月份,count(t.fcreatorid)*1.0,count(distinct t.fcreatorid)*1.0,round(count(t.fcreatorid)*1.0/count(distinct t.fcreatorid)*1.0,1) \"人均单据负荷(张)\" FROM (\n" +
                "SELECT  year(FCREATETIME) year,\n" +
                "            case \n" +
                "                when month(FCREATETIME)<7  then '1' \n" +
                "                else '2' \n" +
                "            end half,\n" +
                "            quarter(FCREATETIME) quarter,\n" +
                "            month(FCREATETIME) month,fcreatorid\n" +
                "FROM T_GL_VOUCHER \n" +
                "union all\n" +
                "SELECT  year(FCREATETIME) year,\n" +
                "            case \n" +
                "                when month(FCREATETIME)<7 then '1' \n" +
                "                else '2' \n" +
                "            end half,\n" +
                "            quarter(FCREATETIME) quarter,\n" +
                "            month(FCREATETIME) month,flastupdateuserid\n" +
                "FROM T_GL_VOUCHER \n" +
                " ) as T\n" +
                "group by\n" +
                "    t.year,\n" +
                "    t.half,\n" +
                "    t.quarter\n";

        System.out.println(systemUserNumSql);
    }
}
