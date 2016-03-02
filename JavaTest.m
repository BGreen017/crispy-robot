% Waypoints = ceil((N)*(rand(2,10)));
Waypoints = [2 3 8 5 1 9 ; 7 4 1 8 8 3];
%<<<<<<< Updated upstream
for ii = 1:length(Waypoints)
    Terrain(Waypoints(1,ii),Waypoints(2,ii)) = 100;
%=======
%for ii = 1:length(Waypoints)
 
%Terrain(Waypoints(1,ii),Waypoints(2,ii)) = inf;
%>>>>>>> Stashed changes
end

javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo/HelloWorld.class'
o = HelloWorld;
javaMethod('main', o, '');

%javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo/UAV.class'  % path to MyJavaThread.class
%javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo/MyThread.class'  % path to MyJavaThread.class
%UAV = javaObjectEDT('UAV',1,2,3);
%start(MyThread(UAV,Terrain,6,6));