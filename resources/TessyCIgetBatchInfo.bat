echo("add tessy commands to the current path")
SET PATH=%PATH%;C:\Program Files (x86)\Razorcat\TESSY_3.2\bin
echo %PATH%
echo("get back to the Project Root")
chdir
cd..
cd..
SET curdir=%cd%
echo("start tessy ")
tessyd --file %curdir%\tessy\tessy.pdbx
tessycmd connect
tessycmd select-project "FuSi_ALL"
tessycmd list-test-collections
tessycmd disconnect
tessyd shutdown
pause