package edu.knoldus.database

import edu.knoldus.model.UserAccount

import scala.collection.mutable.ListBuffer

object Database {

  private var userAccount = new ListBuffer[UserAccount]()

  def getUserAccount: ListBuffer[UserAccount] = userAccount

  def setUserAccount(name: String, userName: String, accountNumber: BigDecimal, address: String, initialAmount: BigDecimal): Boolean = {
    val user = UserAccount(accountNumber, name, address, userName, initialAmount)
    userAccount = userAccount ++ ListBuffer(user)
    true
  }
}
