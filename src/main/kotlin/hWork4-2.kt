fun main() {
    println("Please enter one/two word(s)\nDon't forget the white space.")
    val inputWordList = readLine().toString().lowercase().split(' ')

    //building a loop to count repetition of repeated characters of the input word and adding them to a list
    val listOfRepetitions = mutableListOf<Int>()
    val listOfCharacters = mutableListOf<Char>()
    for (char in inputWordList[0]) {
        if (char in listOfCharacters) {
            break
        } else {
            listOfCharacters.add(char)
            var repetitionOfCharacterCounter = 0
            var j = 0
            while (j in inputWordList[0].indices) {
                if (inputWordList[0][j] == char) {
                    repetitionOfCharacterCounter ++
                }
                j ++
            }
            if (repetitionOfCharacterCounter > 1) {
                listOfRepetitions.add(repetitionOfCharacterCounter)
            }
        }
    }

    //building a loop to calculate the repetitions' factorials and adding them to a list
    val listOfFactorials = mutableListOf<Int>()
    for (i in listOfRepetitions.indices) {
        var factorial = 1
        var j = listOfRepetitions[i]
        while (j != 1) {
            factorial *= j
            j --
        }
        listOfFactorials.add(factorial)
    }

    //building a loop to count all permutations of the input word
    var numberOfWords = 1
    for (i in 2..inputWordList[0].length) {
        numberOfWords *= i
    }

    //calculating number of permutations of the word without repeated ones
    var finalNumberOfWords = numberOfWords
    for (factorial in listOfFactorials) {
        finalNumberOfWords /= factorial
    }

    //creating permutations of the input word
    val words = mutableListOf<String>()
    while (words.size != finalNumberOfWords - 1) {
        var newWord = ""
        val inputWordCharacters = inputWordList[0].toMutableList()
        for (i in inputWordList[0].indices) {
            val character = inputWordCharacters.random()
            newWord += character
            inputWordCharacters.remove(character)
        }
        if (newWord !in words && newWord != inputWordList[0]) {
            words.add(newWord)
        }
    }

    val map = mutableMapOf(inputWordList[0] to words)
    if (inputWordList.size > 1) {
        if (inputWordList[1] in words) {
            println("pass")
        } else {
            println("fail")
        }
    }
    println(map[inputWordList[0]])
}