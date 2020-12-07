import kotlin.math.floor

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int = generateSequence { Dice(6).roll() }
            .take(4)
            .sorted()
            .drop(1)
            .sum()

        fun modifier(score: Int): Int {
            val baseModifier: Double = (score - 10.0) / 2
            return floor(baseModifier).toInt()
        }
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int = (0..sides).random()
}