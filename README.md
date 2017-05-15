# LeaveSystem
請假系統

# 功能
- 三種身分權限:

|編號  |功能        |員工   |主管   |管理員  |
|-----|------------|-------|------|---------|
|1    |新增假單      |   O   |   O  |   O   |
|2    |修改假單      |   O   |   O  |   O   |
|3    |查詢假單      |   O   |O(ALL)|   O   |
|4    |審核假單      |       |   O  |       |
|5    |請假時數查詢  |   O   |O(ALL)|   O   |
|6    |請假時數匯出  |   O   |O(ALL)|   O   |
|7    |假別/時數設定 |       |      |   O   |

- **請假功能**<br />
1.一次可請多種假<br />
2.假單退回/通過，發mail通知<br />
3.自動驗算請假時數是否足夠<br />
4.可修改/註銷假單<br />

- **審核功能**<br />
1.紅框提醒有假單須審核<br />
2.通過/退回發mail通知<br />
3.退回之假單可註銷/修改<br />


- **假別/時數設定**<br />
1.新增/修改可請假 假別<br />
2.新增/修改可請假 年度<br />
3.修改每個人可請假時數<br />
4.新增假別/年度，給予預設150hr可以請<br />

# 使用技術

- MVC架構  <br />

- **front-end**<br />
Javascript / jQuery / ajax / Bootstrap

- **back-end**  <br />
Java EE / Oracle DB

# 介紹影片
[YouTube連結](https://www.youtube.com/watch?v=8cdB1Gu08io)
