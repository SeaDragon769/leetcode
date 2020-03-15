package leetcode

object ReverseString_344 {
  def reverseString(s: Array[Char]): Unit = {
    var temp='c'
    for (i <-0 until s.length/2){
      temp=s(i)
      s(i)=s(s.length-1-i)
      s(s.length-1-i)=temp
    }
  }
}
