package main.kotlin.gdgtorino.hashcode

import main.kotlin.gdgtorino.hashcode.io.OutputData
import main.kotlin.gdgtorino.hashcode.utils.INPUT_FILENAME
import main.kotlin.gdgtorino.hashcode.utils.Utility

object Worker {
    private val outputData: OutputData = OutputData()

    fun execute() {
        println("Main execution starts for $INPUT_FILENAME file")

        val inputData = Utility.read()

        // Intermediate elaboration
        outputData.firstValue = inputData.firstValue
        outputData.secondValue = inputData.secondValue

        println("Output data created: $outputData")

        // Final output generation
        Utility.write(outputData)

        println("Main execution correctly completed")
    }
}