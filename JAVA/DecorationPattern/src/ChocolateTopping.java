/* Chocolate Topping */
// 쿠키에 초콜릿을 첨가합니다.
public class ChocolateTopping extends Topping{
 
    public ChocolateTopping(Cookie cookie) {
        super(cookie);
    }
 
    @Override
    public String getName() {
        return "초콜릿맛 " + cookie.getName();
    }
}