package ru.omyagkov

import cloudflow.flink.{FlinkStreamletContext, FlinkStreamletLogic}

class StreamletLogic(streamlet: StreamletBase)(implicit context: FlinkStreamletContext)
    extends FlinkStreamletLogic with Logging
   {

  override def buildExecutionGraph(): Unit = {

      println("!!!!- "+ streamlet.myMapConfig)

  }


}
