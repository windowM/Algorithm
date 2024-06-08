# 알아두면 좋은 함수들

(잔디 안심기는 버그 테스트)
## 🖊️문자

### 문자 대문자 소문자 확인
```
Character.isLowerCase(문자);
Character.isUpperCase(문자);
```

## 📮문자열

### 문자열 -> 문자 배열 변환
```
char[] ch = 문자열.toCharArray();
```

### 문자열을 역순으로 뒤집는 방법
```
1. new StringBuilder().append(문자열).reverse().toString();
2. new StringBuilder().append(정수[0]).append(정수[1])... .reverse().toString();
```

### 문자열 배열에서 원하는 문자열 찾기
```
1. Arrays.asList(문자열 배열).indexOf(타겟값)
```

### 문자열 대체 메소드 Replace/ReplaceAll
```
1. 문자열.replace(찾는 문자열,변환할 문자열);
2. 문자열.replaceAll(정규식,대체어)
```
![img.png](replace,replaceAll차이.png)

### 문자열 반복
```
repeat(반복할 문자열);
```

## 🔢숫자

### 숫자 1234를 자릿수 별로 가져오는 방법 (chars()가 핵심)
```
String.valueOf(숫자).chars() 
```

### 가져온 후 각 자릿수 합을 구하는 방법
```
String.valueOf(숫자).chars().map(ch->ch-'0').sum();
```

### 정수 배열 중 특정 조건을 걸러 내는 방법
```
정수[] 변수 = Arrays.Stream(정수배열).filter(facotr->조건).toArray();
```


## 📟 배열 (Array)

### b~f까지만 복사
```
Arrays.copyOfRange(배열, 시작 위치, 종료 위치)
```

## 📈 유용함

### 문자 비교 재정의 (Compare)
```
Arrays.sort(배열,new Comparator<타입>(){
    @Override
    public int compare(타입 변수1,타입 변수2){
        if(변수1<변수2) return -1;
        else if(변수1>변수2) return 1;
        else return 0;
    }
});
```

### 우선순위 큐 (PriorityQueue)
```
1. 오름차순
PriorityQueue<타입> pQ = new PriorityQueue<>();
pQ.offer(@@);
pQ.poll();
pQ.peek();  // 가장 작은 값

2. 내림차순
PriorityQueue<타입> pQ = new PriorityQueue<>(Collections.reverseOrder());

```

### 연산자 | 와 || 차이
```
비교 조건으로 사용될 때
1. |는 하나가 참이더라도 다음 비교를 진행 o
2. ||는 하나가 참이면 다음 비교 진행 x

숫자 사이에 사용될 때
1. |는 or연산, &는 and연산, ^는 xor연산, !는 논리 부정
```

## 📐 수학 공식

#### 약수 총 개수 구하기
```
int count = 0;
for(int i=1;i*i<num;i++){
    if(i*i==num) count++;
    else if(i%2==0) count+=2;
}
```

#### 등차, 등비 합
```
n(2a+(n-1)d)/2                  // 등차수열 합
a(1-r^n)/(1-r)                  // 등비수열 합
최대 공약수 x 최대 공배수 = axb     // 최대 공약수, 최대 공배수 관계
```

### !!! (GCD)최대 공약수 공식
```
public int gcd(int a, int b){
    if(b==0) return a;
    return gcd(b,a%b);
}
```

### 10진수 -> 2진 문자열 변환
```
String s = Integer.toBinaryString(정수타입);
```