package simpleassemblerinterpreter

/**
 * https://www.codewars.com/kata/58e24788e24ddee28e000053/train/kotlin
 */
fun interpret(program: Array<String>): Map<String, Int> {
    return Machine(program)
        .run()
        .exposeRegisters()
}

class Machine(program: Array<String>) {
    private val registers = mutableMapOf<String, Int>()
    private val instructions: List<Instruction>

    private var instructionPointer = 0

    init {
        instructions = program.map { tryParseInstruction(it) }
    }

    fun run(): Machine {
        while (instructionPointer < instructions.size) {
            instructions[instructionPointer].execute()
            instructionPointer++
        }

        return this
    }

    fun exposeRegisters(): Map<String, Int> {
        return registers.toMap()
    }

    private fun tryParseInstruction(instruction: String): Instruction {
        when {
            instruction.startsWith("mov ") -> {
                return Mov(instruction, this)
            }

            instruction.startsWith("inc ") -> {
                return Inc(instruction, this)
            }

            instruction.startsWith("dec ") -> {
                return Dec(instruction, this)
            }

            instruction.startsWith("jnz ") -> {
                return Jnz(instruction, this)
            }

            else -> throw IllegalArgumentException("Unknown instruction: $instruction")
        }
    }

    private class Mov(instruction: String, private val machine: Machine) : Instruction {
        private val x: String
        private val y: String

        init {
            val split = instruction.split(" ")
            x = split[1]
            y = split[2]
        }

        override fun execute() {
            machine.registers[x] = y.toIntOrNull() ?: machine.registers[y] ?: 0
        }
    }

    private class Inc(instruction: String, private val machine: Machine) : Instruction {
        private val x: String = instruction.split(" ")[1]

        override fun execute() {
            val value = machine.registers[x] ?: 0
            machine.registers[x] = value + 1
        }
    }

    private class Dec(instruction: String, private val machine: Machine) : Instruction {
        private val x: String = instruction.split(" ")[1]

        override fun execute() {
            val value = machine.registers[x] ?: 0
            machine.registers[x] = value - 1
        }
    }

    private class Jnz(instruction: String, private val machine: Machine) : Instruction {
        private val x: String
        private val y: String

        init {
            val split = instruction.split(" ")
            x = split[1]
            y = split[2]
        }

        override fun execute() {
            val value = x.toIntOrNull() ?: machine.registers[x] ?: 0

            if (value != 0) {
                machine.instructionPointer += y.toInt() - 1
            }
        }
    }
}

interface Instruction {
    fun execute()
}
