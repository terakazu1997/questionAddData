package jdbc;

public class ChangeQuestion {

    public static void main(String[] args) {
        ChangeQuestionData questionData = new ChangeQuestionData();
        //0バイトの問題生成
        questionData.make0ByteQuestion();
        //4000バイトの半角の問題生成
        //questionData.make4000ByteHankakuQuestion();
        //4000バイトの全角の問題生成
        //questionData.make4000ByteZenkakuQuestion();
        //特殊文字半角の問題生成
        //questionData.makeSpecialHankakuQuestion();
        //特殊文字全角の問題生成
        //questionData.makeSpecialZenkakuQuestion();
        //HTMLタグ付き問題を生成
        //questionData.makeHTMLTagQuestion();

        //正答チェックのテスト
        //questionData.makePassCheckQuestion1();
        //questionData.makePassCheckQuestion2();
        //questionData.makePassCheckQuestion3();
    }
}
