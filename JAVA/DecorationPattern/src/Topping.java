/* Topping Class */
// 쿠키 위에 얹을 토핑 클래스(데코레이터)입니다.
public abstract class Topping implements Cookie{
    protected Cookie cookie;
 
    public Topping(Cookie cookie) {
        this.cookie = cookie;
    }
 
    @Override
    public abstract String getName();
}