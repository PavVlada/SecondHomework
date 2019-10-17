package bonch.dev.school.model

class Counter(startCount: Int = 0) {
    var currentCount = startCount
        private set

    fun increment(){
        ++currentCount
    }
}