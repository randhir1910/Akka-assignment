package edu.knoldus.actor

import akka.actor.Actor
import edu.knoldus.database.Database
import edu.knoldus.model.UserAccount

class AccountGeneratorActor extends Actor {
  override def receive: Receive = {
    case account: UserAccount =>
      if (!Database.getUserAccount.exists(_.userName == account.userName)) {

        Database.setUserAccount(account.name, account.userName, account.accountNumber, account.address, account.initialAmount)
        println("user added...")
      }
      else {

        Database.getUserAccount.map(user => println("already already exist " + user.name + " " + user.userName + " " + user.accountNumber + " " + user.address + " " + user.initialAmount))

      }
  }
}
