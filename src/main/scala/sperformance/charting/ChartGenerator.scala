package sperformance
package charting

import intelligence.Cluster

trait ChartGenerator {
  //This method needs *far* more info!!!!
  def generateChart(cluster : Cluster) : Unit
  def canHandleCluster(cluster : Cluster) : Boolean
}