def start_server
	Dir.chdir('src')
	job1 = fork do 
		exec('java Server')
	end
	Process.detach(job1)
	Dir.chdir('..')
end

def call_sut(command)
	Dir.chdir('/Users/antti/Documents/workspace/TennisGameTest/src')
	cmd = "java Client " + command
	IO.popen(cmd, "w+") do |pipe|
	  pipe.close_write
	  output = pipe.read
	  return output.strip
	end
end


def quit_server
	call_sut('bye')
end

at_exit do
	quit_server
end

Before do
	call_sut('reset')
end

start_server
