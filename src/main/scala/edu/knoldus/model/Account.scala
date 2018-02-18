package edu.knoldus.model

sealed trait Account

case class UserAccount(accountNumber: BigDecimal, name: String, address: String, userName: String, initialAmount: Double = 0.0) extends Account

sealed trait Category

case object Phone extends Category

case object Electricity extends Category

case object Internet extends Category

case object Food extends Category

case object Car extends Category


case class Biller(billerCategory: Category, billerName: String, accountNumber: BigDecimal, transactionDate: java.util.Date, amount: Double, totalIterations: Int, executedIterations: Int, paidAmount: Double)


case class User(accountNumber: BigDecimal, name: String, amount: Double) extends Account
