def start_server
	job1 = spawn('java Server')
	Process.detach(job1)
end

def call_sut(command)
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
