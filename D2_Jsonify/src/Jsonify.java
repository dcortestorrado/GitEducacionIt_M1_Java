public class Jsonify {
    public static String construirJson(String[] args) {

        if (args.length == 0) {
            return "No se ingresaron datos.";
        } else {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\"data\":[");

            for (int i = 0; i < args.length; i++) {
                jsonBuilder.append("\"");
                jsonBuilder.append(args[i]);
                jsonBuilder.append("\"");

                if (i != args.length - 1) {
                    jsonBuilder.append(",");
                }
            }

            jsonBuilder.append("]}");

            return jsonBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String resultadoJson = construirJson(args);
        System.out.println(resultadoJson);
    }

}