import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class password {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // ここに暗号化したいパスワードを入れる
        String rawPassword = "satonao1";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }
}