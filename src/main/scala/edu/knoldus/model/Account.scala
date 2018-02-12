package edu.knoldus.model

sealed trait Account

case class UserAccount(accountNumber: BigDecimal, name: String, address: String, userName: String, initialAmount: BigDecimal) extends Account




