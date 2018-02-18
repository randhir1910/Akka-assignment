package edu.knoldus.actor

import akka.actor.Actor
import akka.dispatch.{BoundedMessageQueueSemantics, RequiresMessageQueue}
import edu.knoldus.database.Database
import edu.knoldus.model.{Biller, User, UserAccount}

class AccountGeneratorActor extends Actor with RequiresMessageQueue[BoundedMessageQueueSemantics] {
  override def receive: Receive = {
    case account: UserAccount =>
      if (!Database.getUserAccount.exists(user => user.userName == account.userName)) {

        Database.setUserAccount(account.name, account.userName, account.accountNumber, account.address, account.initialAmount)
        sender ! "user added successfully.."
      }
      else {
        sender ! "user already exist "
      }
    case billerAccount: Biller =>
      Database.setUserBillInfo(billerAccount.billerCategory, billerAccount.billerName, billerAccount.accountNumber, billerAccount.transactionDate,
        billerAccount.amount, billerAccount.totalIterations, billerAccount.executedIterations, billerAccount.paidAmount)
  }
}

class DepositSalary extends Actor {

  override def receive: Receive = {

    case User(accountNumber, name, amount) => if (Database.getUserAccount.exists(user => user.accountNumber == accountNumber && user.userName == name)) {
      Database.depositSalary(accountNumber, name, amount)
    }
  }
}
