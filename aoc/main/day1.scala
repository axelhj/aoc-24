package io.github.axelhj

// using toolkit 0.6.0
// using dep "com.lihaoyi::upickle:4.0.2"
import upickle.default._
// import upickle.default.{ReadWriter => RW, macroRW}

object Main extends App:
    println("Started")
    Run()

    def Run(): Unit =
        val awards: AwardsContainer = read[AwardsContainer](os.read(os.pwd / "csd" / "data" / "Awards.json"))
        // val awards = petOwner.copy(pets = "Toolkitty" :: petOwner.pets)
        println("Completed")
        // println(awards.ikeaFoodCoupon.cost)

// os.write(os.pwd / "pet-owner-updated.json", write(petOwnerUpdated))
