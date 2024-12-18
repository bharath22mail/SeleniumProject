$dynamicText = $CmdLine[1] ; First argument
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1",$dynamicText)
ControlClick("Open","","Button1")