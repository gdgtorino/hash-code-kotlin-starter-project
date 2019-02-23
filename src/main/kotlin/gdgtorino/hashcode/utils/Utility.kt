package main.kotlin.gdgtorino.hashcode.utils

import main.kotlin.gdgtorino.hashcode.io.InputData
import main.kotlin.gdgtorino.hashcode.io.OutputData
import java.io.File
import java.io.IOException

object Utility {
    fun read(): InputData {
        val inputData = InputData()
        try {
            File(INPUT_FILENAME).forEachLine {
                if (inputData.firstValue == null) {
                    // first line
                    val (firstValue, secondValue, thirdValue, fourthValue) = it.split(' ')
                    inputData.firstValue = firstValue
                    inputData.secondValue = secondValue
                    inputData.thirdValue = thirdValue
                    inputData.fourthValue = fourthValue
                } else {
                    //TODO: create dataObjects and add to the list
                    inputData.dataObjects.add(Any())
                }
            }
        } catch (e: Exception) {
            println(MSG_ERR_FIND_INPUT_FILE)
            throw RuntimeException(MSG_ERR_FIND_INPUT_FILE, e)
        }

        println("Input data acquired: $inputData")

        return inputData
    }

    fun write(outputData: OutputData) {
        val file = File(OUTPUT_FILENAME)
        if (!file.exists()) {
            try {
                file.createNewFile()
            } catch (e: IOException) {
                println(MSG_ERR_CREATE_OUTPUT_FILE)
                throw RuntimeException(MSG_ERR_CREATE_OUTPUT_FILE, e)
            }
        }

        try {
            file.printWriter().use {
                it.println(outputData.firstValue)
                it.println(outputData.secondValue)

                //TODO: write the rest of the file
            }
        } catch (e: IOException) {
            println(MSG_ERR_FIND_OUTPUT_FILE)
            throw RuntimeException(MSG_ERR_FIND_OUTPUT_FILE, e)
        }
    }
}