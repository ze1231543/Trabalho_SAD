/**
 * SAD - 1º Sprint - Exercício 2
 * Desencripta hashes com Cifra de César e 2 salts de 3 letras.
 */
public class DecriptadorEx2 {

    // Frequência (%) de cada letra A..Z em português
    static final double[] FREQ_PT = {
            14.63, 1.04, 3.88, 4.99, 12.57, 1.02, 1.30, 1.28, 6.18, 0.40, 0.02, 2.78, 4.74,
            5.05, 10.73, 2.52, 1.20, 6.53, 7.81, 4.34, 4.63, 1.67, 0.01, 0.21, 0.01, 0.47
    };

    // Decifra o texto recuando cada letra 'deslocamento' posições
    public static String decifrarCaesar(String texto, int deslocamento) {
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            int pos = Math.floorMod((c - 'A') - deslocamento, 26);
            sb.append((char) ('A' + pos));
        }
        return sb.toString();
    }

    // Quanto mais a palavra usa letras comuns em português, maior a pontuação
    public static double pontuacao(String texto) {
        double soma = 0;
        for (char c : texto.toCharArray()) {
            soma += FREQ_PT[c - 'A'];
        }
        return soma / texto.length();
    }

    // Mostra as 26 decifrações possíveis de um salt
    public static String candidatosSalt(String salt) {
        String resultado = "";
        for (int k = 0; k < 26; k++) {
            resultado += k + ":" + decifrarCaesar(salt, k) + " ";
        }
        return resultado;
    }

    public static void main(String[] args) {
        // {aluno, hash da coluna "SPRINT 1 - 2"}
        String[][] hashesGrupo = {
                {"1231543 JOSE HENRIQUE CORREIA LEITE", "HXXIMZWXWZBWRVW"},
                {"1241582 ARTUR CARDOSO BERNARDES", "BNCVMBODJBQIAWAY"},
                {"1251659 GUILLERMO ENRIQUE FERREIRA RENDON", "WSCKIBMLZITDMO"}
        };

        for (String[] entrada : hashesGrupo) {
            String hash = entrada[1];
            int n = hash.length();

            // As 3 posições possíveis dos salts: {salt1, mensagem, salt2}
            String[][] posicoes = {
                    {hash.substring(0, 3),         hash.substring(3, n - 3), hash.substring(n - 3)}, // início + fim
                    {hash.substring(n - 6, n - 3), hash.substring(0, n - 6), hash.substring(n - 3)}, // ambos no fim
                    {hash.substring(0, 3),         hash.substring(6),        hash.substring(3, 6)}   // ambos no início
            };

            // Força bruta: 3 posições x 26 deslocamentos, fica com o melhor
            double melhorPontos = -1;
            int melhorK = 0;
            String melhorMensagem = "";
            String[] melhorPosicao = null;

            for (String[] p : posicoes) {
                for (int k = 0; k < 26; k++) {
                    String mensagem = decifrarCaesar(p[1], k);
                    double pontos = pontuacao(mensagem);
                    if (pontos > melhorPontos) {
                        melhorPontos = pontos;
                        melhorK = k;
                        melhorMensagem = mensagem;
                        melhorPosicao = p;
                    }
                }
            }

            System.out.println("Aluno: " + entrada[0]);
            System.out.println("Hash:  " + hash);
            System.out.println("  Mensagem: " + melhorMensagem + " (K = " + melhorK + ")");
            System.out.println("  Salt 1 cifrado: " + melhorPosicao[0] + " -> " + candidatosSalt(melhorPosicao[0]));
            System.out.println("  Salt 2 cifrado: " + melhorPosicao[2] + " -> " + candidatosSalt(melhorPosicao[2]));
            System.out.println();
        }
    }
}