package leetcode
object ValidSudoku_36 {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        val mapA=scala.collection.mutable.Map[Char,scala.collection.Set[Int]]()
        for(i<-board.indices)
            for(j<-board(i).indices){
              val s=board(i)(j)
              if(board(i)(j)!='.')
                if(mapA.contains(board(i)(j)) ){
                  var setA=mapA(board(i)(j))
                  if(setA.contains(i)||setA.contains(j+9)||setA.contains(i/3*3+j/3+18)){
                    return false
                  }else{

                   setA= setA+i
                    setA= setA+(j+9)
                    setA=setA+(i/3*3+j/3+18)
                    mapA.put(board(i)(j),setA)
                  }
                }else{
                  val set=scala.collection.mutable.Set.empty[Int]
                  set.add(i)
                  set.add(j+9)
                  set.add(i/3*3+j/3+18)
                  mapA.put(board(i)(j),set)
                }
            }
        true
    }



    def main(args: Array[String]):Unit = {
        println("Hello World!")
        var myList1 = Array(Array(1.9, 2.9, 3.4, 3.5),Array(1.9, 2.9, 3.4, 3.5))
        println(myList1(0)(0))

        var list=Array(
          Array('8','3','.','.','7','.','.','.','.'),
          Array('6','.','.','1','9','5','.','.','.'),
          Array('.','9','8','.','.','.','.','6','.'),
          Array('8','.','.','.','6','.','.','.','3'),
          Array('4','.','.','8','.','3','.','.','1'),
          Array('7','.','.','.','2','.','.','.','6'),
          Array('.','6','.','.','.','.','2','8','.'),
          Array('.','.','.','4','1','9','.','.','5'),
          Array('.','.','.','.','8','.','.','7','9')
          )
//      var list=Array(
//        Array('5','3','.','.','7','.','.','.','.'),
//        Array('6','.','.','1','9','5','.','.','.'),
//        Array('.','9','8','.','.','.','.','6','.'),
//        Array('8','.','.','.','6','.','.','.','3'),
//        Array('4','.','.','8','.','3','.','.','1'),
//        Array('7','.','.','.','2','.','.','.','6'),
//        Array('.','6','.','.','.','.','2','8','.'),
//        Array('.','.','.','4','1','9','.','.','5'),
//        Array('.','.','.','.','8','.','.','7','9')
//      )
      println(isValidSudoku(list))
      println(2/3*3)
    }
}
