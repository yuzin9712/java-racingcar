# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 자동차 경주 구현 목록

- [X] 사용자 입력을 받는 InputView 구현 - 차 대수와 시도 수를 입력 받는다
- [X] 사용자 입력을 저장하는 데이터 클래스 RacingPlayData를 만든다
- [X] 차량의 시도 횟수에 따른 이동 거리를 저장하는 CarRecordHistory 객체를 만든다
- [X] 게임의 전체 결과를 저장하는 RacingResult를 만든다
- [X] 입력한 차 대수와 시도 수 만큼 게임을 실행하는 코어 로직 CarRacingCore를 구현한다