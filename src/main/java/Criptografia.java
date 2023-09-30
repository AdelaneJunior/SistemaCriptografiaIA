public class Criptografia {

    private static final char[][] tabelaCodigo = {
            {'A', '!'},
            {'B', '@'},
            {'C', '#'},
            {'D', '$'},
            {'E', '%'},
            {'F', '&'},
            {'G', '*'},
            {'H', '/'},
            {'I', '-'},
            {'J', '+'},
            {'K', '3'},
            {'L', '1'},
            {'M', '^'},
            {'N', '~'},
            {'O', '<'},
            {'P', '>'},
            {'Q', '5'},
            {'R', '?'},
            {'S', '°'},
            {'T', ';'},
            {'U', '.'},
            {'V', '}'},
            {'W', ']'},
            {'X', '9'},
            {'Y', '0'},
            {'Z', '='}
    };


    public String criptografarMensagem(String entradaDecodigicada){

        StringBuilder mensagemCriptografada = new StringBuilder();

        for (int i = 0; i < entradaDecodigicada.length(); i++) {

            char letra = entradaDecodigicada.charAt(i);
            boolean codigoEncontrado = false;

            buscarCodigo(letra, mensagemCriptografada, codigoEncontrado);
        }

        return mensagemCriptografada.toString();
    }

    private static void buscarCodigo( char letra, StringBuilder mensagemCriptografada, boolean codigoEncontrado) {
        for (int j = 0; j < tabelaCodigo.length; j++) {
            if (tabelaCodigo[j][0] == letra) {
                mensagemCriptografada.append(tabelaCodigo[j][1]);
                codigoEncontrado = true;
                break;
            }
        }

        if (!codigoEncontrado) {
            mensagemCriptografada.append(letra);
        }
    }

    public String descriptografarMensagem(String entradaCriptografada){

        StringBuilder mensagemDescriptografada = new StringBuilder();

        for (int i = 0; i < entradaCriptografada.length(); i++) {

           char caracter = entradaCriptografada.charAt(i);
           boolean letraEncontrada = false;

            buscarLetra(caracter, mensagemDescriptografada, letraEncontrada);
        }

        return mensagemDescriptografada.toString();
    }

    private static void buscarLetra(char caracter, StringBuilder mensagemDescriptografada, boolean letraEncontrada) {
        for (int j = 0; j < tabelaCodigo.length; j++) {
            if (tabelaCodigo[j][1] == caracter) {
                mensagemDescriptografada.append(tabelaCodigo[j][0]);
                letraEncontrada = true;
                break;
            }
        }

        if (!letraEncontrada) {
            mensagemDescriptografada.append(caracter);
        }
    }

}
