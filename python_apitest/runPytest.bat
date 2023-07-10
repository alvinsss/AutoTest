cd D:\Sourcetree\alvinsss\AutoTest
echo start exec
pytest
echo exec is over
allure generate ./report/allure_json/ -o ./report/allure --clean
allure open -h 127.0.0.1 -p 10086 ./report/allure