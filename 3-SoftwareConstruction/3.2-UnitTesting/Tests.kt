class ExampleUnitTest {
    @Test
    fun doReportSuccess() {
        val result = MainActivity.doReport(1f, 1f, 1f, 1f, 1f, 1f,1)
        assertEquals(MainActivity.SUCCESS, result)
    }
    @Test
    fun doReportID_ERROR() {
        val result = MainActivity.doReport(1f, 1f, 1f, 1f, 1f, 1f,-1)
        assertEquals(MainActivity.ID_ERROR, result)
    }
    @Test
    fun doReportDATA_ERROR() {
        val result = MainActivity.doReport(121f, 1f, 1f, 1f, 1f, 1f,1)
        assertEquals(MainActivity.DATA_ERROR, result)
    }
}
