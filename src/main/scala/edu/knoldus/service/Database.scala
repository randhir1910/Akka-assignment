package edu.knoldus.database

import edu.knoldus.model.{Biller, Category, UserAccount}

import scala.collection.mutable.ListBuffer


object Database {

  private var userAccount = ListBuffer[UserAccount]()

  private var userBillInfo = ListBuffer[Biller]()

  def getUserAccount: ListBuffer[UserAccount] = userAccount

  def setUserAccount(name: String, userName: String, accountNumber: BigDecimal, address: String, initialAmount: Double): Boolean = {
    val user = UserAccount(accountNumber, name, address, userName, initialAmount)
    userAccount = userAccount ++ ListBuffer(user)
    true
  }

  def getUserBillInfo: ListBuffer[Biller] = {

    userBillInfo
  }

  def setUserBillInfo(billerCategory: Category, billerName: String, accountNumber: BigDecimal, transactionDate: java.util.Date,
                      amount: Double, totalIterations: Int, executedIterations: Int, paidAmount: Double): Boolean = {
    val biller = Biller(billerCategory, billerName, accountNumber, transactionDate, amount, totalIterations, executedIterations, paidAmount)
    userBillInfo = userBillInfo ++ ListBuffer(biller)
    true
  }

  def depositSalary(accountNumber: BigDecimal, name: String, amount: Double): Boolean = {

    for (user <- userAccount) {
      if (user.accountNumber == accountNumber && user.name == name) {
        user.initialAmount += amount
        return true
      }
    }
    false
  }
}
