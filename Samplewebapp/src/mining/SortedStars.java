package mining;

public class SortedStars implements Comparable{

public String id;
public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getStar() {
return star;
}

public void setStar(String star) {
this.star = star;
}

public String star;

public SortedStars(String id, String star){
this.id = id;
this.star = star;
}

@Override
public int compareTo(Object o) {
// TODO Auto-generated method stub
SortedStars s = (SortedStars) o;
return (Integer.parseInt(star) - Integer.parseInt(s.star));
}

}
