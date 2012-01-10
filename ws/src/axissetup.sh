AXIS_HOME=/afs/wszib/usr/t/s/tszepie/pub/prir/axis-1_4
for i in $AXIS_HOME/lib/*.jar
do
CLASSPATH=$CLASSPATH:$i;
done;
CLASSPATH=$CLASSPATH:.;
export CLASSPATH
