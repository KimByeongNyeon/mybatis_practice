//package kr.co.sist.mail;
//
//import java.io.UnsupportedEncodingException;
//import java.security.GeneralSecurityException;
//import java.security.NoSuchAlgorithmException;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//
//
//public class EmailSender {
//    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
//    	 // 발신자 이메일 계정 정보
//        final String username = "BRdBKXzNTkQ+qTfHMTWXexX2eVZk3OJ1r4T7iBSkMVA=\r\n"; // 발신자 네이버 이메일 주소
//        final String password = "cthjOuXYgdfaaVCPyX6K8A=="; // 발신자 네이버 이메일 비밀번호
//
//        // SMTP 서버 설정
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true"); //SMTP 서버 인증을 사용하는 설정 ( true - 외부에서 인증 설정 )
//        props.put("mail.smtp.starttls.enable", "true");//TLS 보안을 사용한 연결 설정
//        props.put("mail.smtp.host", "smtp.naver.com");//SMTP 서버의 호스트 명 설정 smtp.naver.com
//        props.put("mail.smtp.port", "587");// SMTP 포트는 587번
//
//        // 세션 생성 : 이메일 메시지를 구성하고 전송하는 데 사용
//        //Authenticator : SMTP서버 인증에 필요한 사용자명과 비번을 전달하는 클래스
//		/* DataDecrypt dd = new DataDecrypt("01234567891054321"); */
//        
//        
//        final String username2 = dd.decryption(username);
//        final String password2 = dd.decryption(password);
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username2, password2);
//            }
//        });
//
//        try {
//            // 메시지 구성
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username2)); // 발신자 이메일
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("qud5212@naver.com")); // 수신자 이메일
//            message.setSubject("네이버를 사용한 메일 테스트입니다."); // 이메일 제목
//            message.setText("안녕메일 테스트 고객님의 아이디는 xxx입니다."); // 이메일 내용
//
//            // 이메일 전송
//            Transport.send(message);
//
//            System.out.println("Email sent successfully!");
//
//        } catch (MessagingException e) {
//            e.printStackTrace(); // 디버깅을 위해 스택 트레이스 출력
//            throw new RuntimeException(e);
//        }
//    }
//}