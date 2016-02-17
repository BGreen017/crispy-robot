%% GenerateMap

% 2 dimensial array
N = 10;
Terrain = zeros(N);

% Waypoints = ceil((N)*(rand(2,10)));
Waypoints = [2 3 8 5 1 9 ; 7 4 1 8 8 3];
for ii = 1:length(Waypoints)
    Terrain(Waypoints(1,ii),Waypoints(2,ii)) = 100;
end

Goal = [2 9];
Start = [2 2];

Terrain(Goal(1),Goal(2)) = 30;
Terrain(Start(1),Start(2)) = 60;

figure 
surf(Terrain)
grid on
