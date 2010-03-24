import _root_.sperformance.charting.ChartingReporterTest
import collection.mutable.ListBuffer
import _root_.sperformance.PerformanceDSLTest

object MyPerformanceTest extends PerformanceDSLTest with ChartingReporterTest {
  performance of "List" in {
    measure method "foreach" in {
      withSize upTo 1000 withSetup { size =>
        (1 to size).toList
      } run { collection =>
        var tmp = 0
        collection.foreach(x => tmp + x)
      }
    }
  }
  performance of "ListBuffer" in {
    measure method "foreach" in {
      withSize upTo 1000 withSetup { size =>
        val collection = new ListBuffer[Int]
        for( i <- 1 to size) collection += i
        collection
      } run { collection =>
        var tmp = 0
        collection.foreach(x => tmp + x)
      }
    }
  }
  performance of "Array" in {
    measure method "foreach" in {
      withSize upTo 1000 withSetup { size =>
        val collection = new Array[Int](size)
        for(i <- 1 to size) collection(i-1) = i
        collection
      } run { collection =>
        var tmp = 0
        collection.foreach(x => tmp = x * 20)
      }
    }
  }
}