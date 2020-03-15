package leetcode

object RotateImage_48 {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    for( i<- 0 until matrix.length/2){
      for(j<-i until matrix.length-i-1){
        val temp=matrix(i)(j)
        matrix(i)(j)=matrix(matrix.length-1-j)(i)
        matrix(matrix.length-1-j)(i)=matrix(matrix.length-1-i)(matrix.length-1-j)
        matrix(matrix.length-1-i)(matrix.length-1-j)=matrix(j)(matrix.length-1-i)
        matrix(j)(matrix.length-1-i)=temp
      }
    }
  }

}
