package DataStructure.stack;

/**
 * Created on 2019/9/29 9:10
 * ����ջ��ʵ�ּ�����
 *
 * @author Haiyang He
 * @version 1.0
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2+5*10";
        //��������ջ����ջ�ͷ���ջ
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //������Ҫ����ر���
        int index = 0;//����ɨ��
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int result = 0;
        char ch = ' '; //��ÿ��ɨ��õ�char���浽ch
        String keepNum = ""; //����ƴ�� ��λ��
        //��ʼwhileѭ����ɨ��expression
        while (true) {
            //���εõ�expression ��ÿһ���ַ�
            ch = expression.substring(index, index + 1).charAt(0);
            //�ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
            if (operStack.isOperator(ch)) {//����������
                //�жϵ�ǰ�ķ���ջ�Ƿ�Ϊ��
                if (!operStack.isEmpty()) {
                    //�������ջ�в��������ͽ��бȽ�,�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ�����,����Ҫ����ջ��pop��������,
                    //�ڴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operStack.pop();
                        result = numStack.cal(num1, num2, operator);
                        //������Ľ������ջ
                        numStack.push(result);
                        //Ȼ�󽫵�ǰ�Ĳ����������ջ
                        operStack.push(ch);
                    } else {
                        //�����ǰ�Ĳ����������ȼ�����ջ�еĲ������� ��ֱ�������ջ.
                        operStack.push(ch);
                    }
                } else {
                    //���Ϊ��ֱ�������ջ..
                    operStack.push(ch); // 1 + 3
                }
            } else { //�����������ֱ������ջ

                //numStack.push(ch - 48); //? "1+3" '1' => 1
                //����˼·
                //1. �������λ��ʱ�����ܷ�����һ������������ջ����Ϊ�������Ƕ�λ��
                //2. �ڴ���������Ҫ��expression�ı��ʽ��index ���ٿ�һλ,��������ͽ���ɨ�裬����Ƿ��Ų���ջ
                //3. ���������Ҫ����һ�������ַ���������ƴ�Ӷ�λ�������ͨ��parseInt����ת��

                //�����λ��
                keepNum += ch;

                //���ch�Ѿ���expression�����һλ����ֱ����ջ
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {

                    //�ж���һ���ַ��ǲ������֣���������֣��ͼ���ɨ�裬����������������ջ
                    //ע���ǿ���һλ������index++
                    if (operStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        //�����һλ�������������ջ keepNum = "1" ���� "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //keepNum���
                        keepNum = "";
                    }
                }
            }
            //��index + 1, ���ж��Ƿ�ɨ�赽expression���.
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //�����ʽɨ����ϣ���˳��Ĵ� ��ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������.
        while (true) {
            //�������ջΪ�գ�����㵽���Ľ��, ��ջ��ֻ��һ�����֡������
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operStack.pop();
            result = numStack.cal(num1, num2, operator);
            numStack.push(result);//��ջ
        }
        //����ջ���������pop�������ǽ��
        int res2 = numStack.pop();
        System.out.printf("���ʽ %s = %d", expression, res2);
    }
}


//�ȴ���һ��ջ����Ҫ��չ����
class ArrayStack2 {
    private int maxSize;//ջ�Ĵ�С
    private int[] stack;//��������ģ��ջ
    private int top = -1;//top��ʾջ������ʼ��Ϊ-1

    //������
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //ջ��
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    //��ջ
    public void push(int value) {
        if (isFull()) {
            System.out.println("ջ������");
            return;
        }
        top++;
        stack[top] = value;
    }

    //��ջ(��ջ�������ݵ���)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("ջ�ǿյ�,�����ݣ�");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //����һ�����������Է��ص�ǰջ����ֵ, ���ǲ���������
    public int peek() {
        return stack[top];
    }

    //��ʾջ�����������ջ��,����ʱ��Ҫ��ջ����ʼ��ʾ����
    public void showStack() {
        if (isEmpty()) {
            System.out.println("ջ�գ������ݣ�");
            return;
        }
        //��Ҫ��ջ����ʼ��ʾ����
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //��������������ȼ������ȼ�ʹ�����ֱ�ʾ������Խ�����ȼ�Խ��,���Ҽٶ���ǰ�ı��ʽֻ��+��-��*��/���ĸ����ţ�������
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //�ж��Ƿ��������
    public boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //���㷽��
    public int cal(int num1, int num2, int operator) {
        int result = 0; // res ���ڴ�ż���Ľ��
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;// ע��˳��
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}