package edu.knoldus.application

import akka.actor.{ActorSystem, Props}
import edu.knoldus.actor.AccountGeneratorActor
import edu.knoldus.model.UserAccount
import org.apache.log4j.Logger

import scala.io.StdIn._

object Application {

  def main(args: Array[String]): Unit = {

    for (i <- 1 to 5) {
      val logger: Logger = Logger.getLogger(this.getClass)
      val system = ActorSystem("banking")
      val actor = system.actorOf(Props[AccountGeneratorActor], "account-creator")
      logger.info("enter name  ")
      val name = readLine()
      logger.info("enter username  ")
      val userName = readLine()
      logger.info("enter address ")
      val address = readLine()
      logger.info("enter initial amount ")
      val amount: BigDecimal = readInt()
      actor ! UserAccount(userName.##, name, address, userName, amount)
      system.terminate()
    }
  }
}
