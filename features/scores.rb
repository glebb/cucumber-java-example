require 'rspec'

When /^nobody has scored$/ do
end

Then /^score is "(.*?)"$/ do |arg1|
  score = call_sut("getScore")
  score.should == arg1
end

When /^player (\d+) scores (\d+) times$/ do |arg1, arg2|
  player = "p" + arg1.to_s
  i = 0
  while i.to_i < arg2.to_i
  	call_sut(player)
  	i = i+1
  end  
end