package basic;

public class VersionControl {

    public boolean isBadVersion(int version){
        return version>=1702766719;
    }

    public int firstBadVersion(int n) {
        int start=1;
        int end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        VersionControl versionControl=new VersionControl();
        versionControl.firstBadVersion(2126753390);
    }

}
