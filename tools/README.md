># 工具类库

>>## 一. 时间处理类
    1. 获取本日，本周，本月，本季度，本年时间段范围
        getTimeUnitsRange(String unit); 
    2. 计算两个日期之间的天数
        getDateRangeDaysNum(LocalDate startDate,LocalDate endDate);
    3. 计算两个日期之间的周数
        getDateRangeWeekNum(LocalDate startDate,LocalDate endDate);
    4. 计算两个日期之间的月数
        getDateRangeMonthNum(LocalDate startDate,LocalDate endDate);
    5. 计算两个日期之间的季度数
        getDateRangeQuarterNum(LocalDate startDate,LocalDate endDate)
    6. 计算两个日期之间的年数
        getDateRangeYearNum(LocalDate startDate,LocalDate endDate)
    7. 
    8. 
    9. 
>>## 一. 地图工具类
    1、获取两个经纬度之间的距离
        getGLtLngDistance(GLatLngEntity g1, GLatLngEntity g2);