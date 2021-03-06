#!/bin/bash

# set $flintrockPemPath as an environmental variable

# $1 is the number of workers and $2 is the numnber of clients


#launch
python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py launch gtcs --num-slaves $(($1+$2))

#set up
python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs 'sudo yum update -y;sudo yum install java-1.8.0-openjdk* -y;export JAVA_HOME="/usr/lib/jvm/java-1.8.0-openjdk";sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo;sudo sed -i s/\$releasever/7/g /etc/yum.repos.d/epel-apache-maven.repo;sudo yum -y install apache-maven;sudo yum -y install git;git clone https://github.com/ybc9977/alluxio-gtcs.git;sudo yum -y install python2-pip;sudo yum -y install gcc-c++;sudo pip install numpy==1.14.4;sudo pip install cvxpy==0.4.9;cd alluxio-gtcs;mvn clean install -DskipTests=true -Dlicense.skip=true -Dcheckstyle.skip -Dmaven.javadoc.skip=true'
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py describe gtcs

# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py copy-file gtcs /Users/ybc/Downloads/alluxio-gtcs.zip /home/ec2-user/
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "unzip alluxio-gtcs"

# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/master/target/miredot/font/Droid_Sans/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/master/target/miredot/font/Droid_Sans_Mono/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/master/target/miredot/font/Open_Sans/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/proxy/target/miredot/font/Droid_Sans/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/proxy/target/miredot/font/Droid_Sans_Mono/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/proxy/target/miredot/font/Open_Sans/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/worker/target/miredot/font/Droid_Sans/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/worker/target/miredot/font/Droid_Sans_Mono/LICENSE.txt"
# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "rm alluxio-gtcs/core/server/worker/target/miredot/font/Open_Sans/LICENSE.txt"

# python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs ""

#read -r line < $(cd `dirname $0`; cd ..; pwd)/flintrock/flintrock.txt
#python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "cp ~/alluxio-gtcs/conf/alluxio-site.properties.template ~/alluxio-gtcs/conf/alluxio-site.properties"
#python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "cp ~/alluxio-gtcs/conf/alluxio-env.sh.template ~/alluxio-gtcs/conf/alluxio-env.sh"
##python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "echo 'alluxio.worker.memory.size=32GB' >> ~/alluxio-gtcs/conf/alluxio-site.properties"
#python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "echo 'alluxio.master.hostname=${line:9}' >> ~/alluxio-gtcs/conf/alluxio-site.properties"
#python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "echo 'alluxio.underfs.address=hdfs://${line:9}:9000'>> ~/alluxio-gtcs/conf/alluxio-site.properties"
#python3 $(cd `dirname $0`; cd ..; pwd)/flintrock/standalone.py run-command gtcs "echo ${line:9} >> ~/alluxio-gtcs/conf/masters"

#sh $(cd `dirname $0`;pwd)/start.sh $1 $2

exit 0
