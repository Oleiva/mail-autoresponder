package services

import akka.actor.ActorSystem
import com.google.inject.Inject
import play.api.Configuration

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class CodeBlockTask @Inject()(config: Configuration,actorSystem: ActorSystem, checkingMails: CheckingMails)(implicit executionContext: ExecutionContext) {

  val host = config.get[String]("mail.host")
  val storeType = config.get[String]("mail.storeType")
  val userName = config.get[String]("mail.userName")
  val password = config.get[String]("mail.password")


  actorSystem.scheduler.schedule(initialDelay = 2.seconds, interval = 5.second) {
    // the block of code that will be executed
    println("Executing something...")

    checkingMails.check(host, storeType, userName, password)
  }


}


