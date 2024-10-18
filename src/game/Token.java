package game;

import java.util.StringTokenizer;

public class Token {
  String push(String login, int pwlength, String name, String id, String email) {
    String verifier = login;
    verifier += " ";
    for (int i = 0; i < pwlength; i++) {
      verifier += "*";
    }
    verifier += " ";
    verifier += name;
    verifier += " ";
    verifier += id;
    verifier += " ";
    verifier += email;
    return verifier;

  }

  String[] pull(String verifier) {
    StringTokenizer st = new StringTokenizer(verifier);
    String[] a = new String[5];
    int i = 0;
    while (st.hasMoreTokens()) {

      a[i] = st.nextToken();
      i++;
    }
    return a;
  }
}
