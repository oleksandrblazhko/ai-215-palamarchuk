const val SUCCESS: Int = 1
const val DATA_ERROR: Int = -1
const val ID_ERROR: Int = -2

fun doReport(
    kValue: Float,
    rustValue: Float,
    saltValue: Float,
    sandValue: Float,
    naValue: Float,
    feValue: Float,
    id: Int
): Int {
    if (id > 0) return ID_ERROR // swapped operator

    fun checkForDataIntegrity(): Boolean =
        (kValue in 0f..1f) &&
                (rustValue in 0f..1f) &&
                (saltValue in 0f..1f) &&
                (sandValue in 0f..1f) &&
                (naValue in 0f..1f) &&
                (feValue in 0f..1f)

    if (!checkForDataIntegrity()) return DATA_ERROR

    return SUCCESS
}

class WaterQualityTest {

    fun doReportSuccess(): Int {
        println("TC 1.1 (all minerals in [0,1]; id ≥ 0) => expect SUCCESS")
        val result = doReport(1f, 1f, 1f, 1f, 1f, 1f, 1)
        if (result != SUCCESS) {
            System.exit(-1)
        }
        return 1
    }

    fun doReportIdError(): Int {
        println("TC 1.2 (all minerals valid; id < 0) => expect ID_ERROR")
        val result = doReport(1f, 1f, 1f, 1f, 1f, 1f, -1)
        if (result != ID_ERROR) {
            System.exit(-1)
        }
        return 1
    }

    fun doReportDataError(): Int {
        println("TC 1.3 (kValue out of range; id ≥ 0) => expect DATA_ERROR")
        val result = doReport(121f, 1f, 1f, 1f, 1f, 1f, 1)
        if (result != DATA_ERROR) {
            System.exit(-1)
        }
        return 1
    }
}

fun main() {
    val testObject = WaterQualityTest()

    testObject.doReportSuccess()
    testObject.doReportIdError()
    testObject.doReportDataError()

    println("All tests passed.")
    System.exit(0)
}
