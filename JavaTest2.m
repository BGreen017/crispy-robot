% Waypoints = ceil((N)*(rand(2,10)));
% Waypoints = [2 3 8 5 1 9 ; 7 4 1 8 8 3];
%<<<<<<< Updated upstream

% for ii = 1:length(Waypoints)
%     Terrain(Waypoints(1,ii),Waypoints(2,ii)) = 100;
% %=======
% %for ii = 1:length(Waypoints)
%  
% %Terrain(Waypoints(1,ii),Waypoints(2,ii)) = inf;
% %>>>>>>> Stashed changes
% end

% Terrain(3,3) = 100;

% javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo'
% o = HelloWorld;
% javaMethod('main', o, '');

javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo/UAV.class'  % path to UAV.class
javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo/MyThread3.class'  % path to MyThread3.class
javaaddpath '/Users/brandongreen/Documents/workspace2/OneThirtyTwo/Thread3.class'  % path to Thread3.class

x1 = 1;
x2 = 2;

BalloonZ = 3;
BalloonY = 3;

UAV = javaObjectEDT('UAV',1,2,3, BalloonZ, BalloonY);
UAV2 = javaObjectEDT('UAV',79,7,5,BalloonZ, BalloonY);
uavArray = javaArray('UAV',x1);
%uavArray(1,1) = UAV;
uavArray(1,1) = UAV2;

o = Thread3;

a = javaMethod('readThreads',o,uavArray);

plot(a(1,:), a(2,:));
axis([0, 10, 0, 10]);
grid on;
%start(MyThread2(UAV));
%start(MyThread2(UAV2));
