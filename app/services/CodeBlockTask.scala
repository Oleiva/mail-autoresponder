package services

import akka.actor.ActorSystem
import com.google.inject.Inject

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class CodeBlockTask @Inject()(actorSystem: ActorSystem, checkingMails: CheckingMails)(implicit executionContext: ExecutionContext) {

  actorSystem.scheduler.schedule(initialDelay = 2.seconds, interval = 5.second) {
    // the block of code that will be executed
    println("Executing something...")
    System.out.println("test")
    printBar()
  }


  def printBar(): Unit = {
    val host = "pop.gmail.com"
    val storeType = "pop3s"
    val userName = ""
    val password = ""

    checkingMails.check(host, storeType, userName, password)
  }


}


